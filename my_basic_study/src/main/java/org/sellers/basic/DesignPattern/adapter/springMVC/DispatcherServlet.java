package org.sellers.basic.DesignPattern.adapter.springMVC;

import org.sellers.basic.DesignPattern.adapter.springMVC.adapter.HandlerAdapter;
import org.sellers.basic.DesignPattern.adapter.springMVC.adapter.impl.AnnotationHandlerAdapter;
import org.sellers.basic.DesignPattern.adapter.springMVC.adapter.impl.HttpHandlerAdapter;
import org.sellers.basic.DesignPattern.adapter.springMVC.adapter.impl.SimpleHandlerAdapter;
import org.sellers.basic.DesignPattern.adapter.springMVC.controller.Controller;
import org.sellers.basic.DesignPattern.adapter.springMVC.controller.impl.HttpController;

import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet {
    private static final List<HandlerAdapter> handlerAdapters=new ArrayList<>();

    public DispatcherServlet(){
        handlerAdapters.add(new AnnotationHandlerAdapter());
        handlerAdapters.add(new HttpHandlerAdapter());
        handlerAdapters.add(new SimpleHandlerAdapter());
    }

    //模拟spring MVC从request获取handler的对象
    public void doDispatch(){
        //适配器可以获取到希望的handler
        HttpController controller=new HttpController();
//        AnnotationController controller=new AnnotationController();
//        SimpleController controller=new SimpleController();
        //得到对应适配器
        HandlerAdapter adapter=getHandler(controller);
        //通过适配器执行对应的controller方法
        adapter.handle(controller);
    }

    public HandlerAdapter getHandler(Controller controller){
        for (HandlerAdapter adapter:handlerAdapters){
            if (adapter.supports(controller))
                return adapter;
        }
        return null;
    }

    public static void main(String[] args) {
        new DispatcherServlet().doDispatch();
    }
}
