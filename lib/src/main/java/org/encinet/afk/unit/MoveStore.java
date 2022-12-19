package org.encinet.afk.unit;

import org.bukkit.Location;

public class MoveStore {
    Location location;
    long time;

    public MoveStore(Location location) {
        this.location = location;
        time = System.currentTimeMillis();
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public long getTime() {
        return System.currentTimeMillis() - time;
    }
    public void setTimeNow() {
        this.time = System.currentTimeMillis();
    }
}
