package com.ai.sysframe.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import com.ai.sysframe.exception.BaseException;
import com.ai.sysframe.utils.PathUtil;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;

/**
 * @ClassName: PdfGeneratorService
 * @Description: 生成PDF的服务类
 * @author linyl linyuliang.85@gmail.com
 */
@Service
public class PdfGeneratorService {
    /**
     * Output a pdf to the specified outputstream
     * @param htmlStr the htmlstr
     * @param out the specified outputstream
     * @throws Exception
     */
    public void generate(final String htmlStr, final String pdfPathName) {
        try {

            final DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            final Document doc = builder.parse(new ByteArrayInputStream(htmlStr.getBytes("UTF-8")));
            PathUtil.createDir(new File(pdfPathName));
            final OutputStream out = new FileOutputStream(pdfPathName);
            final ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(doc, null);

            // 解决中文支持问题
            final ITextFontResolver fontResolver = renderer.getFontResolver();
            fontResolver.addFont(PathUtil.FONT_PATH + "simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            //fontResolver.addFont(PathUtil.FONT_PATH + "ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            //fontResolver.addFont("E:\\ProvinceCode\\mapp_SD\\src\\main\\webapp\\resources\\fonts\\ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            //fontResolver.addFont("C:\\Users\\Administrator\\project\\GJF_MOBILE\\dev\\server\\mapp\\src\\main\\webapp\\resources\\fonts\\CAMBRIA.TTC", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);


            // 解决图片的相对路径问题
            renderer.getSharedContext().setBaseURL("file:"+PathUtil.WEB_ROOT_PATH);
            //renderer.getSharedContext().setBaseURL("C:\\Users\\Administrator\\project\\GJF_MOBILE\\dev\\server\\mapp\\src\\main\\resources\\freemaker\\template\\");
            renderer.layout();
            renderer.createPDF(out);
            out.close();
        } catch (final FileNotFoundException e) {
            throw new BaseException("58", e);
        } catch (final ParserConfigurationException e) {
            throw new BaseException("59", e);
        } catch (final SAXException e) {
            throw new BaseException("60", e);
        } catch (final IOException e) {
            throw new BaseException("61", e);
        } catch (final DocumentException e) {
            throw new BaseException("62", e);
        }
    }
}
