package com.notfound.crm.sys.util.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.notfound.crm.sys.service.IEmployeeService;
import com.notfound.crm.sys.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @Description: 员工类的回调监听器
 */
@Component
@Scope("prototype")   //此处必须换成多例模式
public class EmployeeReadListener extends AnalysisEventListener<EmployeeVO> {

    private ArrayList<EmployeeVO> listData = new ArrayList<>();

    @Autowired
    private IEmployeeService employeeService;

    @Override
    public void invoke(EmployeeVO data, AnalysisContext context) {
        System.out.println("调用了Employee的表格导入:"+data);
        listData.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //读取完成，批量插入数据
        employeeService.addBatch(listData);
    }
}
