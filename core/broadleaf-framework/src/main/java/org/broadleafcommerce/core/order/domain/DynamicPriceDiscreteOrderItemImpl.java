/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.broadleafcommerce.core.order.domain;

import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.order.service.manipulation.OrderItemVisitor;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.common.presentation.AdminPresentationClass;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * 
 * @author jfischer
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "BLC_DYN_DISCRETE_ORDER_ITEM")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="blOrderElements")
@AdminPresentationClass(friendlyName = "dynamicPriceOrderItem")
public class DynamicPriceDiscreteOrderItemImpl extends DiscreteOrderItemImpl implements DynamicPriceDiscreteOrderItem {

	private static final long serialVersionUID = 1L;

	@Override
	public void setSku(Sku sku) {
		this.sku = sku;
		this.name = sku.getName();
	}

	@Override
	public boolean updatePrices() {
		return false;
	}
	
	@Override
	public void accept(OrderItemVisitor visitor) throws PricingException {
        visitor.visit(this);
    }

}