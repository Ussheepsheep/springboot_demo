package com.githup.ussheepsheep.util;

/**
 * Created by daren on 2017/2/24.
 * <p>
 * 工具类用于获取唯一的序列号
 */
public class Uid {

    /**
     * 获取时间为前缀的有序的uid
     */
    private static class OrderUid {

        OrderUid(int max) {
            this.max = max;
            this.format = "%0" + String.valueOf(max).length() + "d";
        }

        private int max;

        private String format;

        private int order = 0;

        public String uid() {
            synchronized (this) {
                order = order >= max ? 0 : ++order;
                String num = String.format(format, order);
                return new StringBuilder().append(TimeUtil.nowStr()).append(num).toString();
            }
        }
    }

    private static final OrderUid ORDER_UID = new OrderUid(999999);

    public static String orderUid() {
        return ORDER_UID.uid();
    }


}
