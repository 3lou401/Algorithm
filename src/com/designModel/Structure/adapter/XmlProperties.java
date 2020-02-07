package com.designModel.Structure.adapter;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.util.Properties;

/**
 * @Author: leaderHoo
 * @Date: 2020/1/17 18:26
 * @Desc: 就是一个适配器模式， 题外话 ， Java中使用XML , SAX2 (Simple API for XML)
 */
public class XmlProperties {
    public static void main(String[] args) throws SAXException {
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
//            登记事件处理器，这样XmlReader中发生事件变化时，XmlReader会自动触动事件
//        xmlReader.setContentHandler();
//        xmlReader.setDTDHandler();
    }
}
