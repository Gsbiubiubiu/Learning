package com.gs.designmodel.ordermodel.command;

/**
 * @author: Gaos
 * @Date: 2023-01-16 10:48
 **/
public class CopyCommand extends Command{


    CopyCommand(Editor editor) {
        super(editor);
    }
    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}