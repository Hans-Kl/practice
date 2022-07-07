package com.hans.springboot.validate;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

/**
 * @author klhans
 */
@Getter
@Setter
public class Foo {
    @Min(value = 18,groups = {Foo.Adult.class})
    private Integer age;

    public interface Adult{}

    public interface Minor{}
}
