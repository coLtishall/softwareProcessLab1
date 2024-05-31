package dimensions;

import java.util.List;

public interface NoBlankIntervalSet<L> {
    /**
     * 判断一个已经处理完成的时间轴的start与end之间是否没有空隙
     * @return 无返回true，否则返回false
     */
    public boolean checkIfNonblank();

    /**
     * 对时间轴上的时间段进行排序
     * @return 排序后的时间段集合
     */
    public List<L> sort();
}
