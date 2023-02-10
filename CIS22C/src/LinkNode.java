public class LinkNode {
    private Currency data;
    private LinkNode next;

    public LinkNode(Currency data) {
        this.data = data;
        this.next = null;
    }

    public Currency getData() {
        return data;
    }

    public void setData(Currency data) {
        this.data = data;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }
}
