package com.letitgo.lottery.node.node.doc;

import com.letitgo.lottery.util.Constant;
import com.letitgo.lottery.util.struct.SpecialNodeValidate;
import com.letitgo.lottery.util.struct.Validating;

/**
 * Created by aaa on 2017/1/31.
 */
public final class RootNode extends ContainerNode {
    private char[] docTypeNode;
    private SpecialNodeValidate head;
    private SpecialNodeValidate body;

    private boolean checkingStandard = false;
    //the node is not necessarily special when the standardUsedLength is not zero
    private int standardUsedLength = 0;

    // TODO: 2017/2/5 全局
    private Validating validateHead;
    private Validating validateBody;

    public RootNode(){
        super.setNodeLevel(Constant.Root_Level);
        this.validateHead = new Validating(new HeadNode());
        this.validateBody = new Validating(new BodyNode());
    }

    @Override
    public void initElementType(char c) {
        super.initElementType(c);
        this.checkNodeType(c);
    }

    private void checkNodeType(char c){
        this.checkStandardNode(c);
        //doctype or notes
    }

    private void checkDocTypeNode(char c){
        // TODO: 2017/2/1 DocType只有Root有
    }

    private void checkStandardNode(char c){
        if (this.head == null) {
            if (this.validateHead.checkEnd(c)){
                this.head = this.validateHead.getNode();
                this.validateHead = null;
            }
        }
        if (this.body == null) {
            if (this.validateBody.checkEnd(c)){
                this.head = validateBody.getNode();
                this.validateBody = null;
            }
        }
    }

    /*public void init(InputStream inputStream, String encode) throws IOException {
        InputStreamReader inputStreamReader = PageContentOperation.tranToInputStreamReader(inputStream, encode);
        String content = "";
        int tChar = 0;
        ElementNode currentNode = new ElementNode();
        while((tChar = inputStreamReader.read()) != -1){
            //if not end,the total content add the value of the stream read this time
            currentNode.optChar((char)tChar);
        }
        inputStreamReader.close();
    }*/
}
