package com.ppu.taxi.ws.pojo;

import com.ppu.taxi.ws.domain.driver.QueueDriver;

public class QueueInfo {
	private QueueDriver queueinfo;
	private Long curr_queue_no;

	public QueueDriver getQueueinfo() {
		return queueinfo;
	}
	public void setQueueinfo(QueueDriver queueinfo) {
		this.queueinfo = queueinfo;
	}
	public Long getCurr_queue_no() {
		return curr_queue_no;
	}
	public void setCurr_queue_no(Long curr_queue_no) {
		this.curr_queue_no = curr_queue_no;
	}
	@Override
	public String toString() {
		return "QueueInfo [queueinfo=" + queueinfo + ", curr_queue_no=" + curr_queue_no + "]";
	}
	
	
}
