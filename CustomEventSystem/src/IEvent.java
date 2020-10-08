package io.github.Si1kn.Event.EI;

public class IEvent {
    private boolean cancelled;

    public boolean isCancelled() {
        return cancelled;
    }
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
