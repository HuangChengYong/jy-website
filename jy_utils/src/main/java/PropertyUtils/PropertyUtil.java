package PropertyUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Randy.Lau
 * Date: 5/5/14
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyUtil {
    private static final Log log = LogFactory.getLog(PropertyUtil.class);

    private PropertyUtil() {}

    private static PropertyUtil instance = null;
    // 单件设计
    public static PropertyUtil getInstance() {
        if(instance == null){
            synchronized(PropertyUtil.class){
                //when more than two threads run into the first null check same time, to avoid instanced more than one time, it needs to be checked again.
                if(instance == null){
                    instance = new PropertyUtil();
                }
    }
        }
        return instance;
    }

    public static String getProperty(String key) {
        // common为文件名，去掉properties
        String value = null;
        try {
            //Locale locale = Locale.getDefault();
            Locale locale = new Locale("zh", "CN");
//            ResourceBundle bundle = ResourceBundle.getBundle("cn.tctms.infrastructure.conf.common", locale);
            ResourceBundle bundle = ResourceBundle.getBundle("conf.common");

            value = bundle.getString(key);
            if (StringUtils.isEmpty(value)) {
                log.error("配置文件中无对应的键值：" + key);
            }
        }   catch (MissingResourceException ex) {
            log.error("读取配置文件失败：" + key);
        }

        return value;
    }

    public static String getRedisProperty(String key) {
        // common为文件名，去掉properties
        String value = null;
        try {
            //Locale locale = Locale.getDefault();
            Locale locale = new Locale("zh", "CN");
//            ResourceBundle bundle = ResourceBundle.getBundle("cn.tctms.infrastructure.conf.common", locale);
            ResourceBundle bundle = ResourceBundle.getBundle("conf.redis");

            value = bundle.getString(key);
            if (StringUtils.isEmpty(value)) {
                log.error("配置文件中无对应的键值：" + key);
            }
        }   catch (MissingResourceException ex) {
            log.error("读取配置文件失败：" + key);
        }

        return value;
    }

    public static String getSolrProperty(String key) {
        // solr为文件名，去掉properties
        String value = null;
        try {
            //Locale locale = Locale.getDefault();
            Locale locale = new Locale("zh", "CN");
//            ResourceBundle bundle = ResourceBundle.getBundle("cn.tctms.infrastructure.conf.common", locale);
            ResourceBundle bundle = ResourceBundle.getBundle("conf.solr");

            value = bundle.getString(key);
            if (StringUtils.isEmpty(value)) {
                log.error("配置文件中无对应的键值：" + key);
            }
        }   catch (MissingResourceException ex) {
            log.error("读取配置文件失败：" + key);
        }

        return value;
    }
}
