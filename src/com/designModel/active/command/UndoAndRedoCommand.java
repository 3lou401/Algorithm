package com.designModel.active.command;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/4 21:57
 * @Desc:
 */
public class UndoAndRedoCommand {
    public static void main(String[] args) {

    }
}

abstract class CommandUn{
    abstract void execute();
    abstract void undo();
}

