package service;

import context.ControllerContext;
import entity.Method;
import repository.MethodRepository;
import repository.UsedMethodRepository;

public class ConfigureMethodService {
    private static ConfigureMethodService instance;
    private ConfigureMethodService() { }
    public static ConfigureMethodService getInstance()
    {
        if(instance==null)
        {
            instance = new ConfigureMethodService();
        }
        return instance;
    }
    public void configure(String page)
    {
        Method method = MethodRepository.getInstance().getCurrentMethod();
        method.setPage(Short.parseShort(page));
        UsedMethodRepository.getInstance().addMethod(method);
        ControllerContext.getInstance().getAddMethodController().close();
    }
}
