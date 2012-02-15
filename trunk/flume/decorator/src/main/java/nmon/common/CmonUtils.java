package nmon.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: muda1120
 * Date: 12. 2. 10.
 * Time: PM 4:52
 * To change this template use File | Settings | File Templates.
 */
public class CmonUtils {
    
    public static final String BBBP_PROCNETDEV = "/proc/net/dev";

    public static HashMap<String, Method> extractVOMethods(Method[] methods, String kindOfMethod) {
   		HashMap<String, Method> mResult = null;

   		if(methods.length > 0) mResult = new HashMap<String, Method>();

   		for(Method method : methods){
   			if(method.getName().startsWith(kindOfMethod)){
   				mResult.put(method.getName().substring(3),method);
   			}

   		}

   		return mResult;
   	}


    public static String transformCamelName(String value) {
        StringBuilder sb = new StringBuilder();
        if(value.indexOf("_") != -1){
            String[] splitValues = value.split("_");
            for(int i=0; i < splitValues.length; i++){
                sb.append(splitValues[i].replaceFirst(splitValues[i].substring(0, 1), splitValues[i].substring(0, 1).toUpperCase()));
            }

        }else sb.append(value.replaceFirst(value.substring(0, 1), value.substring(0, 1).toUpperCase()));

        return sb.toString();
    }
    
    public static void stringInjectToPojo(Map<String, Method> methodMap, Object injectClass, String colume, Object value) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Method m;
        List valueList = null;
        String[] splitValue;
//        injectClass = (Class) injectClass.newInstance();

        if (methodMap.containsKey(colume)) {

            m = (Method) methodMap.get(colume);
            Class paramClass = m.getParameterTypes()[0];
            if (String.class.toString().equals(paramClass.toString())) {
                m.invoke(injectClass, value);
            } else if (List.class.toString().equals(paramClass.toString())) {
                valueList = new ArrayList<String>();
                splitValue = (String[])value;
                for(int i=2; i < splitValue.length; i++){
                    valueList.add(splitValue[i]);
                }

                m.invoke(injectClass, valueList);
            }
        }
    }

}
