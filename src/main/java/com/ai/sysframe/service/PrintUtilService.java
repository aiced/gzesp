package com.ai.sysframe.service;

import java.awt.print.PrinterJob;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.sysframe.exception.BaseException;

/**
 * @ClassName: PrintService
 * @Description: 打印的服务类
 * @author sunjl2
 */
@Service
public class PrintUtilService {
    /**
     * @Fields LOGGER : 日志操作类
     */
    protected static final Logger LOGGER = LoggerFactory.getLogger(PrintUtilService.class);

//    @Resource
//    HtmlGeneratorService htmlGeneratorService;

    @Resource
    PdfGeneratorService pdfGeneratorService;

    /**
     * @Title: print
     * @Description: 远程调用打印机打印模板内容
     * @param template html模板，参考存放路径：src\main\resources\freemaker\template
     * @param variables html模板入参
     * @param filePath 服务器上传路径
     * @param printName 打印机名称
     */
    public void print(final String filePath, final String printName) {
        final DocFlavor flavor = new DocFlavor("application/x-java-jvm-local-objectref", "java.awt.print.Pageable");
        final PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        final PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, aset);
        if (services.length == 0) {
            throw new BaseException("65");
        }
        PrintService service = null;
        int k = 0;
        for (final PrintService ps : services) {
            if (ps.getName().equals(printName)) {
                service = services[k];
                break;
            } else {
                k++;
            }
        }
        if (service == null) {
            throw new BaseException("70", new Object[] { printName });
        }

        // send pdf to printer
        PDDocument document = null;
        try {
            document = PDDocument.load(filePath);
            // document.silentPrint();
            final PrinterJob printJob = PrinterJob.getPrinterJob();
            printJob.setPrintService(service);
            printJob.setPageable(document);
            printJob.print();
        } catch (final Exception e) {
            throw new BaseException("66", e);
        } finally {
            if (document != null) {
                try {
                    document.close();
                } catch (final IOException e) {
                    LOGGER.warn("打印后关闭PDF文档失败：" + e.getMessage());
                }
            }
        }
    }
}
