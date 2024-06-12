package com.platzi.pizza.persitence.audit;

import com.platzi.pizza.persitence.entity.PizzaEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.SerializationUtils;

public class AuditPizzaListener {
    private static final Logger log = LoggerFactory.getLogger(AuditPizzaListener.class);
    private PizzaEntity currentPizza;

    @PostLoad
    public void postLoad(PizzaEntity entity) {
        log.info("POST LOAD");
        this.currentPizza = SerializationUtils.clone(entity);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(PizzaEntity entity) {
        log.info("POST PERSIST OR UPDATE");
        log.info("OLD VALUE {}", this.currentPizza);
        log.info("NEW VALUE {}", entity.toString());
    }

    @PreRemove
    public void onPreDelete(PizzaEntity entity) {
        log.info("se detecto eliminacion a la tabla pizza {}", entity.toString());
    }

}
