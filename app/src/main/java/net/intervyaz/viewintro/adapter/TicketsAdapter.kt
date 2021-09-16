package net.intervyaz.viewintro.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.intervyaz.viewintro.model.Ticket
import net.intervyaz.viewintro.databinding.TicketItemBinding

class TicketsAdapter(var tickets: List<Ticket>)
    : RecyclerView.Adapter<TicketsAdapter.TicketsHolder>() {

    var clickListener: TicketClickListener? = null

    interface TicketClickListener{
        fun onTicketClick(id: Int)
    }

    override fun getItemCount(): Int {
        return tickets.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TicketItemBinding.inflate(
            inflater,
            parent,
            false
        )

        return TicketsHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: TicketsHolder, position: Int) {
        holder.bind(tickets[position])
    }

    class TicketsHolder(
        private val binding: TicketItemBinding,
        private val listener: TicketClickListener?
        )
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(ticket: Ticket) {
            with(binding) {
                ticketNumber.text = ticket.flightNumber
                departureTime.text = ticket.startTime
                departurePlace.text = ticket.startPlace
                arrivalTime.text = ticket.endTime
                arrivalPlace.text = ticket.endPlace
                flightDate.text = ticket.date
                flightTime.text = ticket.flightTime
                ticketCard.setOnClickListener {
                    listener?.onTicketClick(ticket.id)
                }
            }
        }
    }
}