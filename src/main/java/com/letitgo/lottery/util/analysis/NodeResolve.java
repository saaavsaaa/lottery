package com.letitgo.lottery.util.analysis;

import com.letitgo.lottery.entity.node.doc.DocNode;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by aaa on 18-8-10.
 */
public class NodeResolve {
    private final String input;
    private String current;
    private int position;
    private boolean ended;
    private final Map<String, DocNode> strategies = new ConcurrentHashMap<>();
    
    public NodeResolve(final String input) {
        this.input = input;
    }
    
    public void next() {
        
    }
    
    public boolean isEnd() {
        return ended;
    }
    
    public String getCurrent() {
        return current;
    }
}
