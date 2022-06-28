package com.geekbang.supermarket.interfaces;

public interface Card {
    /**
     * ִ����ϳ�������Ĵ��۲���֮��ȷ���˹˿���Ҫ������Ǯ��
     * Ȼ���ٸ��ݹ˿��Ƿ���VIP�����ж��Ƿ�������ۣ����˿��Ƿ����ֽ𿨣��ֿ��ֽ�
     *
     * @param totalCost              ��Ʒ��ԭ���ܼ�
     * @param totalCostAfterDiscount ʵ���곬�л����ܼ�
     * @param customer               ����Ĺ˿�
     * @param shoppingCart           ���ﳵ
     * @return �Żݶע�ⲻ���Żݺ�ļ۸�
     */
    double processCardDiscount(double totalCost, double totalCostAfterDiscount,
                               Customer customer, ShoppingCart shoppingCart);

}
