/*
package com.miniProject.interviewProject.Repository;

import com.miniProject.interviewProject.Entities.Student;
import com.miniProject.interviewProject.Filter.StudentFilter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentRepository  {

    private IStudentRepository studentRepository;

    public List<Student>

    private Specification<Student> createSpecification(StudentFilter filter){
        switch (filter.getOperator()){
            case EQUAL:
                return((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(filter.getField()),
                                castToRequiredType(root.get(filter.getField()).getJavaType(),filter.getValue())));
        }
    }

    private Object castToRequiredType(Class fieldType, String value){
        if(fieldType.isAssignableFrom(Double.class)){
            return Double.valueOf(value);
        }else if(fieldType.isAssignableFrom(Integer.class)){
            return Integer.valueOf(value);
        }else if(Enum.class.isAssignableFrom(fieldType)){
            return Enum.valueOf(fieldType, value);
        }
        return null;
    }

    private Specification<Student> nameLike(String name){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Student_.NAME), "%"+name+"%");
    }

}

*/
