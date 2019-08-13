/*******************************************************************************
 * (C) Copyright 2010-2019 hSenid Mobile Solutions (Pvt) Limited.
 * All Rights Reserved.
 *
 * These materials are unpublished, proprietary, confidential source code of
 * hSenid Mobile Solutions (Pvt) Limited and constitute a TRADE SECRET
 * of hSenid Mobile Solutions (Pvt) Limited.
 *
 * hSenid Mobile Solutions (Pvt) Limited retains all title to and intellectual
 * property rights in these materials.
 ******************************************************************************/

package hms.sort.core;

public class SelectionSort
{
    public void SelectionSort(int[] array)
    {
        int n = array.length;

        for (int i = 0; i < n-1; i++)
        {
            int minIdx = i;
            for (int j = i+1; j < n; j++)
            {
                if (array[j] < array[minIdx])
                {
                    minIdx = j;
                }

            }
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }

    }

}
