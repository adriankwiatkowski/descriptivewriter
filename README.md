# Sample output

# Example usage:
```java
        System.out.println(buildDescriptiveText("i=i+1;",
                                                "Add one to i",
                                                TextAlignment.CENTER));
        System.out.println(buildDescriptiveText("i=i+1;",
                                                "Add one to i",
                                                TextAlignment.LEFT));
        System.out.println(buildDescriptiveText("i=i+1;",
                                                "Add one to i",
                                                TextAlignment.RIGHT));
        System.out.println(buildDescriptiveText("i=i+1;",
                                                "Add one to i",
                                                TextAlignment.CENTER,
                                                5));
        System.out.println(buildDescriptiveText("i=i+1;",
                                                "Add one to i\nAdd one to i\nAdd\none\nto\ni",
                                                TextAlignment.CENTER));
        System.out.println(buildDescriptiveText("i=i+1;\ni=i+1;",
                                                "Add one to i\nAdd one to i\nAdd\none\nto\ni",
                                                TextAlignment.CENTER));
```
# Output for example code:
```text
/**********************
 *                    *
 *    Add one to i    *
 *                    *
 **********************/
         i=i+1;         

/**********************
 *                    *
 *Add one to i        *
 *                    *
 **********************/
i=i+1;                  

/**********************
 *                    *
 *        Add one to i*
 *                    *
 **********************/
                  i=i+1;

/*******
 *     *
 *Add o*
 *ne to*
 *   i *
 *     *
 *******/
  i=i+1; 

/**********************
 *                    *
 *    Add one to i    *
 *    Add one to i    *
 *         Add        *
 *         one        *
 *         to         *
 *          i         *
 *                    *
 **********************/
         i=i+1;         

/**********************
 *                    *
 *    Add one to i    *
 *    Add one to i    *
 *         Add        *
 *         one        *
 *         to         *
 *          i         *
 *                    *
 **********************/
         i=i+1;         
         i=i+1;         
```
