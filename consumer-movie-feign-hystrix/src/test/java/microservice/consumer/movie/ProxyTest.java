package microservice.consumer.movie;
import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//被代理的接口及实现类

interface Manager {
    public void modify();
}

class ManagerImpl implements Manager {
    public void modify() {
        System.out.println("*******modify()方法被调用");
    }
}
//自定义的调用处理器
class BusinessHandler implements InvocationHandler {
    private Object object = null;

    public BusinessHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do something before method");
        //通过反射调用代理方法，即接口实现类中的方法
        Object ret = method.invoke(this.object, args);
        System.out.println("do something after method");
        return ret;
    }
}
    //获取代理对象并调用方法
public class ProxyTest {
    public static void main(String[] args) {
  	//原对象(被代理对象)
	ManagerImpl managerImpl = new ManagerImpl();
	//业务代理类
	BusinessHandler businessHandler = new BusinessHandler(managerImpl);
	//获得代理类($Proxy0 extends Proxy implements Manager)的实例
	Manager managerProxy = (Manager) Proxy.newProxyInstance(
                    managerImpl.getClass().getClassLoader(),
                    managerImpl.getClass().getInterfaces(),
                    businessHandler);
	//通过代理对象调用实现类中的方法
            managerProxy.modify();
    }
}