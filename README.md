
###### 使用自定义注解+反射实现简易支付方式



```
/*

【注意点】因为对象通过反射生成，故没有被spring管理，无法使用@Autowired等方式
自动注入对象，需要继承 InitNewService.java 类

*/


@Service
public class  InitNewService implements ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(InitNewService.class);

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 将继承此类的service中的字段（注解了@Autowired 或者@Resource）等注入进来
     */
    public InitNewService(){

        if (this.applicationContext == null){
            return;
        }

        if (this.getClass().isAnnotationPresent(org.springframework.stereotype.Service.class)
                || this.getClass().isAnnotationPresent(org.springframework.stereotype.Controller.class)
                || this.getClass().isAnnotationPresent(org.springframework.stereotype.Component.class) ){
            return;
        }

        Class clazz = this.getClass();
        do {
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(org.springframework.beans.factory.annotation.Autowired.class)
                        || f.isAnnotationPresent(javax.annotation.Resource.class)){

                    try {
                        String simpleName = f.getType().getSimpleName();

                        String beanName = simpleName.substring(0,1).toLowerCase()+ simpleName.substring(1);

                        //String beanName = StrUtils.toLowerCaseFirstOne(simpleName);

                        Object bean = applicationContext.getBean(beanName);
                        if (bean == null){
                            return;
                        }

                        boolean accessible = f.isAccessible();
                        f.setAccessible(true);
                        f.set(this,bean);
                        f.setAccessible(accessible);
                    }catch (Exception e){
                        logger.error(clazz.getName() + "当new对象注入类" + f.getName() + "的时候，发生了错误",e);
                        e.printStackTrace();
                    }

                }
            }
            clazz = clazz.getSuperclass();
        } while (clazz != Object.class);
    }

}


```
