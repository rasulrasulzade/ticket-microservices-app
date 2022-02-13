package com.company.ticketservice.service;

import com.company.ticketservice.dto.TicketDto;
import com.company.ticketservice.entity.Ticket;
import com.company.ticketservice.enumeration.PriorityType;
import com.company.ticketservice.enumeration.TicketStatus;
import com.company.ticketservice.model.es.TicketModel;
import com.company.ticketservice.repository.TicketRepository;
import com.company.ticketservice.repository.es.TicketElasticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;
    private final TicketElasticRepository  ticketElasticRepository;

    @Override
    public TicketDto getById(String id) {
        return null;
    }

    @Override
    public TicketDto save(TicketDto ticketDto) {
        //TicketDto -> Ticket
        Ticket ticket = new Ticket();
        //TODO verify assigne from account api
        //ticketDto.setAssignee();

        if(ticketDto.getDescription() == null){
            throw new IllegalArgumentException("Description can't be null");
        }
        ticket.setDescription(ticketDto.getDescription());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));

        //save Ticket to mysql
        ticket = ticketRepository.save(ticket);

        //Ticket -> TicketModel
        TicketModel ticketModel = TicketModel.builder()
                .id(ticket.getId())
                .notes(ticket.getNotes())
                .description(ticket.getDescription())
                .ticketDate(ticket.getTicketDate())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .priorityType(ticket.getPriorityType().getLabel())
                .build();

        //save TicketModel to elastic
        ticketElasticRepository.save(ticketModel);

        //return updated TicketDto
        ticketDto.setId(ticket.getId());
        return ticketDto;
    }

    @Override
    public TicketDto update(String id, TicketDto ticketDto) {
        return null;
    }

    @Override
    public Page<TicketDto> getPage(Pageable pageable) {
        return null;
    }
}
