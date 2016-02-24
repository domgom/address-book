package com.gumtree.specification;

/**
 * Created by dgomez on 24/2/16.
 */
public class DaysOlderBillThanPaul extends DaysOlder {

    private static final String BILL = "Bill ";
    private static final String PAUL = "Paul ";

    public DaysOlderBillThanPaul() {
        super(BILL, PAUL);
    }
}
