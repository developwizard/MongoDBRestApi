package com.example.mongodbrestapi.config;

import com.example.mongodbrestapi.entity.Employee;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class EmployeeModelListener extends AbstractMongoEventListener<Employee> {
    private final SequenceGeneratorService sgs;

    public EmployeeModelListener(SequenceGeneratorService sgs) {
        this.sgs = sgs;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Employee> event) {
        // Before call save method set id value to 0
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sgs.generateSequence(Employee.SEQUENCE_NAME));
        }
    }
}
