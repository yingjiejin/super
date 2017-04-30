package com.supermarket.generator.utils;

import com.google.common.collect.Maps;
import com.supermarket.generator.core.Table;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

public class CodeUtils {

    private static String entityFileTemplate;
    private static String tablePrefix;

    public static File genJavaEntity(String floder, String packageName, Table table) throws IOException {
        String content = gen(packageName, table);
        File file = new File(floder + packageName.replaceAll("\\.", "\\") + tableToJava(table.getName(), tablePrefix) + ".java");
        StreamUtils.copy(content, Charset.forName("UTF-8"), new FileOutputStream(file));
        return file;
    }

    private static String gen(String packageName, Table table) throws IOException {
        Map<String, Object> context = Maps.newConcurrentMap();
        context.put("package", packageName);
        context.put("table", table);
        context.put("className", tableToJava(table.getName(), tablePrefix));
        return gen(entityFileTemplate, context);
    }

    private static String gen(String templatePath, Map<String, Object> context) throws IOException {
        StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        String template = FileUtils.readFileToString(new File(templatePath));
        Template t = gt.getTemplate(template);
        t.binding(context);
        return t.render();

    }

    public static String tableToJava(String tableName, String tablePrefix) {
        if (StringUtils.isNotBlank(tablePrefix)) {
            tableName = tableName.replace(tablePrefix, "");
        }
        return columnToJava(tableName);
    }

    public static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }
}
