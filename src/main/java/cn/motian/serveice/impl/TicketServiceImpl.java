package cn.motian.serveice.impl;

import cn.motian.mapper.TicketMapper;
import cn.motian.model.Ticket;
import cn.motian.serveice.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public boolean addTicket(Ticket ticket) {
        if (ticket == null) {
            return false;
        }
        return ticketMapper.insert(ticket);
    }

    @Override
    public Ticket getByUnionId(String unionId) {
        return ticketMapper.getByUnionId(unionId);
    }

    @Override
    public boolean updateTicketStatus(Ticket ticket) {
        return ticketMapper.updateTicketStatus(ticket);
    }


    public List<Ticket> getByScheduleId(String scheduleId) {
        return ticketMapper.getByScheduleId();
    }

    @Override
    public Ticket getTicketByScheduleIdAndSeatId(String seatId, String scheduleId) {
        return ticketMapper.getTicketByScheduleIdAndSeatId(seatId, scheduleId);
    }

}
