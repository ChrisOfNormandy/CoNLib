package com.github.chrisofnormandy.conlib.itemgroup;

public class GroupList {
    public Groups blocks;
    public Groups slabs = null;
    public Groups stairs = null;
    public Groups walls = null;
    public Groups fences = null;

    public GroupList(Groups blocks) {
        this.blocks = blocks;
    }

    public GroupList getRock() {
        GroupList list = new GroupList(blocks);

        list.slabs = slabs == null ? blocks : slabs;
        list.stairs = stairs == null ? blocks : stairs;
        list.walls = walls == null ? blocks : walls;

        return list;
    }

    public GroupList getWood() {
        GroupList list = new GroupList(blocks);

        list.slabs = slabs == null ? blocks : slabs;
        list.stairs = stairs == null ? blocks : stairs;
        list.fences = fences == null ? blocks : fences;

        return list;
    }
}
