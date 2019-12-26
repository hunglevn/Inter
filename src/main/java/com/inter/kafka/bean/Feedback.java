package com.inter.kafka.bean;

public class Feedback {

    private String msg;
    private String title;

    public Feedback() {

    }

    public Feedback(String msg, String name) {
        this.msg = msg;
        this.title = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
    public String toString() {
        return msg + ", " + title + "!";
    }
}
