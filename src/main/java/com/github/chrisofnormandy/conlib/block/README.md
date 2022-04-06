# C/V Template:
```java
    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_(String name) {
        return BlockRegistry.register(name, new );
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_(String name, ItemGroup group) {
        return BlockRegistry.register(name, new , group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_(String name, Properties properties) {
        return BlockRegistry.register(name, new );
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new , group);
    }
```