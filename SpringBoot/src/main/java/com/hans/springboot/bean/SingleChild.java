package com.hans.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author klhans
 */
@Component
@AllArgsConstructor
public class SingleChild {
    public PrototypeFamliy prototypeFamliy;

    public PrototypeFamliy getPrototypeFamliy() {
        return prototypeFamliy;
    }

    public void setPrototypeFamliy(PrototypeFamliy prototypeFamliy) {
        this.prototypeFamliy = prototypeFamliy;
    }
}
