package com.geekbang.supermarket.interfaces;

public interface Customer {
    String getCustId();

    /**
     * ��ʼ����ǰ��׼��
     */
    void startShopping();

    /**
     * @return �˿��빺�����Ʒ������
     */
    Category chooseCategory();

    /**
     * �˿��Ƿ������Ʒ
     *
     * @param merchandise �ж��Ƿ�Ҫ�������Ʒ
     * @return ������ٸ�
     */
    int buyMerchandise(Merchandise merchandise);


    /**
     * �˿��Ƿ����ˣ�Ҫ����
     *
     * @return true��Ҫ���ˣ� false��������
     */
    boolean wantToCheckout();


    /**
     * ����
     *  @param shoppingCart �˴ι������Ʒ�Ĺ��ﳵ
     * @param totalCost    ���������ۿ۲����ۿۺ���ۺ��ܼ�
     * @return �ɹ�֧������֧����Ǯ�����򷵻�-1
     */
    double payFor(ShoppingCart shoppingCart, double totalCost);

    /**
     *
     * @return �˿ͻ���Ǯ
     */
    double getMoneySpent();
}
