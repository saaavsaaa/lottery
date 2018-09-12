package com.letitgo.lottery.util.analysis;

import com.letitgo.lottery.node.node.doc.DocNode;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by aaa on 18-8-10.
 */
public class NodeResolve {
    private final String input;
    private DocNode current;
    private int position;
    private final Map<String, DocNode> nodes = new ConcurrentHashMap<>();
    
    public NodeResolve(final String input) {
        this.input = input;
    }
    
    public void next() {
        if (isEnd()) {
            return;
        }
        int nodeBegin = ++position;
        while (!isEnd() && NodeSelector.continueNext(input.charAt(position))) {
            position++;
        }
        String nodeText = input.substring(nodeBegin, position);
        current = NodeSelector.build(nodeText);
        nodes.put(nodeText, current);
    }
    
    public boolean isEnd() {
        return position >= input.length();
    }
    
    public DocNode getCurrent() {
        return current;
    }
}
