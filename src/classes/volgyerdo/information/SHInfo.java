/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.information;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import volgyerdo.commons.collection.CollectionUtils;
import volgyerdo.commons.primitive.ArrayUtils;

/**
 * Shannon Hierarchy Information
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class SHInfo {

    public static double information(Object object) {
        byte[] array = ArrayUtils.toByteArray(object);
        return information(array);
    }

    public static double information(boolean[] values) {
        return information(CollectionUtils.convertBooleanArrayToList(values));
    }

    public static double information(byte[] values) {
        return information(CollectionUtils.convertByteArrayToList(values));
    }

    public static double information(short[] values) {
        return information(CollectionUtils.convertShortArrayToList(values));
    }

    public static double information(int[] values) {
        return information(CollectionUtils.convertIntArrayToList(values));
    }

    public static double information(float[] values) {
        return information(CollectionUtils.convertFloatArrayToList(values));
    }

    public static double information(double[] values) {
        return information(CollectionUtils.convertDoubleArrayToList(values));
    }

    public static double information(char[] values) {
        return information(CollectionUtils.convertCharArrayToList(values));
    }

    public static double information(String[] values) {
        return information(Arrays.stream(values).collect(Collectors.toList()));
    }

    public static double information(String values) {
        return information(CollectionUtils.convertStringToCharList(values));
    }

    public static double information(List values) {
        if (values.size() <= 1) {
            return 0;
        }
        int N = values.size();
        int r = N / 2;
        List<List> parts = CollectionUtils.breakApart(values, r, false);
        double info = ShannonInfo.information(parts) + information(parts.get(0)) + information(parts.get(1));
//        info *= values.size() / (double) (parts.size() * r);
        return info;
    }

    private SHInfo() {
    }

}
