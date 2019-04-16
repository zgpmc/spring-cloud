package com.example.cloudconfig.extend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 创建时间:2019/04/08
 * 创建人:pmc
 * 描述:该类用于解决配置中文乱码 需要重新实现PropertySourceLoader接口 属性用utf8方式读取
 */
public class UTF8PropertySourceLoader implements PropertySourceLoader
{
    private Logger logger = LoggerFactory.getLogger(UTF8PropertySourceLoader.class);

    /**
     * Returns the file extensions that the loader supports (excluding the '.').
     *
     * @return the file extensions
     */
    @Override
    public String[] getFileExtensions()
    {
        return new String[]{"properties", "xml"};
    }

    /**
     * Load the resource into one or more property sources. Implementations may either
     * return a list containing a single source, or in the case of a multi-document format
     * such as yaml a source for each document in the resource.
     *
     * @param name     the root name of the property source. If multiple documents are loaded
     *                 an additional suffix should be added to the name for each source loaded.
     * @param resource the resource to load
     * @return a list property sources
     * @throws java.io.IOException if the source cannot be loaded
     */
    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException
    {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try
        {
            inputStream = resource.getInputStream();
            properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        } catch (IOException ioEx)
        {
            logger.error("load inputStream failed", ioEx);
            throw ioEx;
        } catch (Exception e)
        {
            logger.error("load inputStream failed", e);
        } finally
        {
            if (inputStream != null)
            {
                inputStream.close();
            }
        }

        List<PropertySource<?>> propertySourceList = null;
        if (!properties.isEmpty())
        {

            PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource(name, properties);
            propertySourceList = new ArrayList<>();
            propertySourceList.add(propertiesPropertySource);
        }
        return propertySourceList;

    }
}
