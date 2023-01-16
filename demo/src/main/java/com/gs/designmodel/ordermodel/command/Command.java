package com.gs.designmodel.ordermodel.command;

/**
 * @author: Gaos
 * @Date: 2023-01-16 10:47
 **/
public abstract class Command {
    public Editor editor;
    private String backup;

    Command(Editor editor){
        this.editor = editor;
    }

    void backup () {
        backup = editor.textField.getText();
    }

    public void undo() {
        editor.textField.setText(backup);
    }

    public abstract boolean execute();
}