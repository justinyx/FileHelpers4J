/*
 * MasterDetailWriteFileTest.java
 *
 * Copyright (C) 2007 Felipe Gon�alves Coury <felipe.coury@gmail.com>
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.github.vicenthy.filehelpers4j.tests.masterdetail;

import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

import com.github.vicenthy.filehelpers4j.masterdetail.CommonSelector;
import com.github.vicenthy.filehelpers4j.masterdetail.MasterDetailEngine;
import com.github.vicenthy.filehelpers4j.masterdetail.MasterDetails;
import com.github.vicenthy.filehelpers4j.tests.common.Common;
import com.github.vicenthy.filehelpers4j.tests.types.customers.CustomersVerticalBar;
import com.github.vicenthy.filehelpers4j.tests.types.orders.OrdersVerticalBar;

public class MasterDetail2Test extends TestCase {
	MasterDetailEngine<CustomersVerticalBar, OrdersVerticalBar> engine;
	
	@SuppressWarnings("unchecked")
	public void testCustomerOrdersRead() throws IOException {
		engine = new MasterDetailEngine<CustomersVerticalBar, OrdersVerticalBar>(CustomersVerticalBar.class, OrdersVerticalBar.class, CommonSelector.DetailIfContains, "@");		
		
		List<MasterDetails<CustomersVerticalBar, OrdersVerticalBar>> res = 
			(List<MasterDetails<CustomersVerticalBar, OrdersVerticalBar>>) Common.readTest(engine, "Good/MasterDetail2.txt");
		
        assertEquals(4, res.size());

        assertEquals(4, engine.getTotalRecords());

        assertEquals(4, res.get(0).getDetails().size());
        assertEquals(3, res.get(1).getDetails().size());
        assertEquals(2, res.get(2).getDetails().size());
        assertEquals(0, res.get(3).getDetails().size());

        assertEquals("ALFKI", ((CustomersVerticalBar) res.get(0).getMaster()).customerID);
        assertEquals(10248, ((OrdersVerticalBar) res.get(0).getDetails().get(0)).orderID);
        assertEquals(10249, ((OrdersVerticalBar) res.get(0).getDetails().get(1)).orderID);
        assertEquals(10250, ((OrdersVerticalBar) res.get(0).getDetails().get(2)).orderID);
        assertEquals(10251, ((OrdersVerticalBar) res.get(0).getDetails().get(3)).orderID);
        
        assertEquals("ANATR", ((CustomersVerticalBar) res.get(1).getMaster()).customerID);
        assertEquals(10252, ((OrdersVerticalBar) res.get(1).getDetails().get(0)).orderID);
        assertEquals(10253, ((OrdersVerticalBar) res.get(1).getDetails().get(1)).orderID);
        assertEquals(10254, ((OrdersVerticalBar) res.get(1).getDetails().get(2)).orderID);

        assertEquals("ANTON", ((CustomersVerticalBar)res.get(2).getMaster()).customerID);
        assertEquals(10257, ((OrdersVerticalBar)res.get(2).getDetails().get(0)).orderID);
        assertEquals(10258, ((OrdersVerticalBar)res.get(2).getDetails().get(1)).orderID);

        assertEquals("DUMON", ((CustomersVerticalBar)res.get(3).getMaster()).customerID);		
	}

	@SuppressWarnings("unchecked")
	public void testCustomerOrdersRead2() throws IOException {
		engine = new MasterDetailEngine<CustomersVerticalBar, OrdersVerticalBar>(CustomersVerticalBar.class, OrdersVerticalBar.class, CommonSelector.MasterIfContains, "@");		
		
		List<MasterDetails<CustomersVerticalBar, OrdersVerticalBar>> res = 
			(List<MasterDetails<CustomersVerticalBar, OrdersVerticalBar>>) Common.readTest(engine, "Good/MasterDetail3.txt");
		
        assertEquals(4, res.size());

        assertEquals(4, engine.getTotalRecords());

        assertEquals(4, res.get(0).getDetails().size());
        assertEquals(3, res.get(1).getDetails().size());
        assertEquals(2, res.get(2).getDetails().size());
        assertEquals(0, res.get(3).getDetails().size());

        assertEquals("ALFKI", ((CustomersVerticalBar) res.get(0).getMaster()).customerID);
        assertEquals(10248, ((OrdersVerticalBar) res.get(0).getDetails().get(0)).orderID);
        assertEquals(10249, ((OrdersVerticalBar) res.get(0).getDetails().get(1)).orderID);
        assertEquals(10250, ((OrdersVerticalBar) res.get(0).getDetails().get(2)).orderID);
        assertEquals(10251, ((OrdersVerticalBar) res.get(0).getDetails().get(3)).orderID);
        
        assertEquals("ANATR", ((CustomersVerticalBar) res.get(1).getMaster()).customerID);
        assertEquals(10252, ((OrdersVerticalBar) res.get(1).getDetails().get(0)).orderID);
        assertEquals(10253, ((OrdersVerticalBar) res.get(1).getDetails().get(1)).orderID);
        assertEquals(10254, ((OrdersVerticalBar) res.get(1).getDetails().get(2)).orderID);

        assertEquals("ANTON", ((CustomersVerticalBar)res.get(2).getMaster()).customerID);
        assertEquals(10257, ((OrdersVerticalBar)res.get(2).getDetails().get(0)).orderID);
        assertEquals(10258, ((OrdersVerticalBar)res.get(2).getDetails().get(1)).orderID);

        assertEquals("DUMON", ((CustomersVerticalBar)res.get(3).getMaster()).customerID);		
	}
}
