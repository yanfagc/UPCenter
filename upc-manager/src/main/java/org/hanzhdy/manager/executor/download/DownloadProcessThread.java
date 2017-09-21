package org.hanzhdy.manager.executor.download;


import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.hanzhdy.manager.engine.utils.DateTimeUtils;
import org.hanzhdy.manager.engine.utils.ExcelUtils;
import org.hanzhdy.utils.resources.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by H.CAAHN on 2017/6/27.
 */
public class DownloadProcessThread implements Runnable {


    private static final Logger logger = LoggerFactory.getLogger(DownloadProcessThread.class);


    public void run() {
        try {
            this.handle(Calendar.getInstance());
        } catch (Exception ex) {
            logger.error("文件下载进程记录保存失败", ex);
        }
    }

    protected void handle(Calendar calendar) throws Exception {

    }

    protected HSSFSheet buildExcelSheet(HSSFWorkbook workbook, String sheetName, List<ExcelColumn> columnList) {
        HSSFCellStyle style1 = ExcelUtils.generateCellStyle(workbook);
        style1.setFont(ExcelUtils.generateFont(workbook));
        HSSFCellStyle style2 = ExcelUtils.generateCellStyle2(workbook);
        style2.setFont(ExcelUtils.generateFont2(workbook));

        HSSFSheet sheet = workbook.createSheet(sheetName);
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < columnList.size(); i++) {
            sheet.setColumnWidth(i, columnList.get(i).getWidth());
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style1);
            HSSFRichTextString text = new HSSFRichTextString(columnList.get(i).getName());
            cell.setCellValue(text);
        }
        return sheet;
    }

    protected int buildExcelContent(HSSFSheet sheet, int nowline, List dataList, List<ExcelColumn> columnList) {
        if (dataList == null || dataList.isEmpty()) {
            return nowline;
        }

        for (Object data : dataList) {
            HSSFRow row = sheet.createRow(nowline);
            for (int i = 0; i < columnList.size(); i++) {
                HSSFCell cell = row.createCell(i);
                cell.setCellValue(columnList.get(i).getValue(data));
            }
            nowline++;
        }

        return nowline;
    }

    protected File createFile(String fileNameFormat, Calendar calendar) throws IOException {
        String rootPath = Resources.getString("file.path.download");
        if (StringUtils.isBlank(rootPath)) {
            throw new RuntimeException("下载文件的根目录配置信息不存在：file.path.download");
        }

        String nowday = DateTimeUtils.format(calendar.getTime(), "yyyyMMdd");
        if (!rootPath.endsWith("/") && !rootPath.endsWith("\\")) {
            rootPath += File.separator;
        }

        File dic = new File(rootPath + nowday);
        if (!dic.exists() || !dic.isDirectory()) {
            dic.mkdirs();
        }

        String fileName = MessageFormat.format(fileNameFormat, this.getFileId(calendar));

        File file = new File(rootPath + nowday + "/" + fileName);
        file.createNewFile();
        return file;
    }

    protected String createFileName(String fileNameFormat, Calendar calendar) throws IOException {

        String nowday = DateTimeUtils.format(calendar.getTime(), "yyyyMMdd");

        String fileName = MessageFormat.format(fileNameFormat, this.getFileId(calendar));

        return fileName;
    }

    protected void writeFile(File file, HSSFWorkbook workbook) throws Exception {
        OutputStream ouputStream = null;
        try {
            ouputStream = new FileOutputStream(file);
            workbook.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (ouputStream != null) {
                try {
                    ouputStream.close();
                } catch (Exception ex) {

                }
            }
        }
    }

    protected String getFileId(Calendar calendar) {
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        StringBuffer buf = new StringBuffer();
        buf.append(hour).append(minute).append(second);
        return buf.toString();
    }
}
