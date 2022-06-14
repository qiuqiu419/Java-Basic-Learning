package com.geekbang.supermarket;

public class LittleSuperMarket {
    public String superMarketName;
    public String address;
    public int parkingCount;
    public double incomingSum;
    public MerchandiseV2[] merchandises;
    public int[] merchandiseSold;
    public double activityDiscount;

    /**
     * ��ʼ��С����
     *
     * @param superMarketName  ��������
     * @param address          ���е�ַ
     * @param parkingCount     ͣ������λ����
     * @param merchandiseCount ��Ʒ������
     * @param count            ÿ����Ʒȱʡ���
     */
    public LittleSuperMarket(String superMarketName, String address, int parkingCount, int merchandiseCount, int count) {
        this.superMarketName = superMarketName;
        this.address = address;
        this.parkingCount = parkingCount;

        merchandises = new MerchandiseV2[merchandiseCount];
        for (int i = 0; i < merchandises.length; i++) {
            double purchasePrice = Math.random() * 200;
            // ����������Ʒ�����Ը�ֵ
            MerchandiseV2 m = new MerchandiseV2(
                    "��Ʒ" + i,
                    "ID" + i,
                    count,
                    purchasePrice * (1 + Math.random()),
                    purchasePrice
            );
            // �ô�������Ʒ������Ʒ����ĵ�i�����ø�ֵ��all��С���е���Ʒ��������ָ�����ͬһ���������
            merchandises[i] = m;
        }
        merchandiseSold = new int[merchandises.length];
        activityDiscount = 0.8;
    }

    // �򵥵ķ��ʳ�Ա����

    public String getSuperMarketName() {
        return superMarketName;
    }

    public String getAddress() {
        return address;
    }

    public int getParkingCount() {
        return parkingCount;
    }

    public double getIncomingSum() {
        return incomingSum;
    }

    public void setSuperMarketName(String superMarketName) {
        this.superMarketName = superMarketName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setParkingCount(int parkingCount) {
        this.parkingCount = parkingCount;
    }

    public void setIncomingSum(double incomingSum) {
        this.incomingSum = incomingSum;
    }

    public void setMerchandises(MerchandiseV2[] merchandises) {
        this.merchandises = merchandises;
    }

    public void setMerchandiseSold(int[] merchandiseSold) {
        this.merchandiseSold = merchandiseSold;
    }



    /**
     * �õ�������ߵ���Ʒ
     *
     * @return
     */
    public MerchandiseV2 getBiggestProfitMerchandise() {
        MerchandiseV2 curr = null;
        for (int i = 0; i < merchandises.length; i++) {
            MerchandiseV2 m = merchandises[i];
            // ����߼�����������ͬ��������ô�жϣ�
            if (curr == null || curr.calculateProfit() < m.calculateProfit()) {
                curr = m;
            }
        }
        return curr;
    }

    /**
     * ����������ȡ��Ʒ
     *
     * @param merchandiseIndex
     * @return
     */
    public MerchandiseV2 getMerchandiseOf(int merchandiseIndex) {
        if (merchandiseIndex < 0 || merchandiseIndex >= merchandises.length) {
            return null;
        }
        return merchandises[merchandiseIndex];
    }

    /**
     * ׬Ǯ
     *
     * @param toBeAdded
     */
    public void addIncomingSum(double toBeAdded) {
        this.incomingSum += toBeAdded;
    }

    /**
     * ��Ǯ
     *
     * @param toBeSpent
     * @return
     */
    public boolean spendMoney(double toBeSpent) {
        if (toBeSpent > incomingSum) {
            return false;
        }
        incomingSum -= toBeSpent;
        return true;
    }

}