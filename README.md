
# Maven Multi Module Project using IDEA in Linux

This is maven multi module project which have two modules service and core.

* Service module contain three sorting algorithms, Bubble Sort, Insertion Sort and Selection Sort.
* Core module have application logic to execute these algorithms. It will get set of numbers as command line inputs execute those three algorithms and print the result.

 

## Prerequisites

* Java 8
* Maven
* Intellij IDEA

1. Create a maven parent module using following code.

```bash
mvn archetype:generate
```
 Provide 1695 or 1691 POM-Root as artifact ID.


2. Create other two modules service and core using same command. 


```bash
mvn archetype:generate
```
3. Open the the poject uisng IDEA.
 
4. Create three java classes inside core module and write three algorithm separately.

####
Bubble Sort

```bash

package hms.sort.core;

public class BubbleSort {
    public void bubbleSort(int[] array){
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
```

####
Selection Sort

```bash

package hms.sort.core;

public class SelectionSort{

    public void SelectionSort(int[] array){
        int n = array.length;
        for (int i = 0; i < n-1; i++){
            int minIdx = i;
            for (int j = i+1; j < n; j++){
                if (array[j] < array[minIdx]){
                    minIdx = j;
                }
            }
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
    }
}
```

####
Insertion Sort

```bash

package hms.sort.core;

public class InsertionSort {

    public void InsertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
```

5. create a java class inside service module and write a code to get inputs, execute and print result.

```bash
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
```
7. Clean and build the project using maven life cycle commands.

```bash
mvn clean
```
```bash
mvn package
```
8. Add the packing as .jar into the pom.xml in service module.


```bash
<packaging>jar</packaging>
```
9. Add core modules as a dependency into the pom.xml in service module.

```bash
<dependency>
<groupId>hms.sort.core</groupId>
<artifactId>core</artifactId>
<version>1.0-SNAPSHOT</version>
<scope>compile</scope>
</dependency>
```

10. The add maven assembly plugin with the main method of core module.


```bash
<plugin>
<artifactId>maven-assembly-plugin</artifactId>
<configuration>
<archive>
<manifest>
<mainClass>hms.cmd.service.Execute</mainClass>
</manifest>
</archive>
<descriptorRefs>
<descriptorRef>jar-with-dependencies</descriptorRef>
</descriptorRefs>
</configuration>
</plugin>
```

11. Execute the clan command with assembly code to execute 


```bash
mvn clean install assembly:single

```
12. Jar file will create inside the build module of service named 
'service-1.0-SNAPSHOT-jar-with-dependencies'. Execute the following command with set of numbers inside the target directory of service module

```bash
java -jar service-1.0-SNAPSHOT-jar-with-dependencies.jr
```






