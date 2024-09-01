package com.watch.shop.app.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class SmartWatch extends Watch {
    private boolean hasHeartRateMonitor;
    private OS os;
}
