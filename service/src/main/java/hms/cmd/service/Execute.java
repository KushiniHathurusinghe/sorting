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

package hms.cmd.service;

import hms.sort.core.BubbleSort;
import hms.sort.core.InsertionSort;
import hms.sort.core.SelectionSort;

public class Execute {




    public static void main(String args[]) {
        BubbleSort bs = new BubbleSort();
        InsertionSort is = new InsertionSort();
        SelectionSort ss = new SelectionSort();



        int array[] = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            array[i] = Integer.parseInt(args[i]);

        }


        int bsArray[] = array;
        bs.bubbleSort(bsArray);
        System.out.println("Sorted Using Bubble Sort ");
        printArray(bsArray);


        int isArray[] = array;
        is.InsertionSort(isArray);
        System.out.println("Sorted Using Insertion Sort ");
        printArray(isArray);

        int ssArray[] = array;
        ss.SelectionSort(ssArray);
        System.out.println("Sorted Using Selection Sort ");
        printArray(ssArray);




    }

    private static void printArray(int[] array) {
        int n = array.length;
        for (int i=0; i<n; ++i) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }


}
