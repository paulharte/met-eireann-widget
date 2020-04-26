package com.harte.meteireannwidget.met;

enum StationName {
    Athenry,
    Ballyhaise,
    Belmullet,
    Casement,
    Claremorris,
    Cork,
    Dublin,
    Dunsany,
    Finner,
    Gurteen,
    Johnstown_Castle,
    Mace_Head,
    Malin_Head,
    Markree_Castle,
    Moore_Park,
    Mt_Dillon,
    Mullingar,
    NewportMayo,
    Oak_Park,
    Phoenix_Park,
    Roche__s_Point,
    Shannon,
    Sherkin_Island,
    Valentia;

    @Override
    public String toString() {
        return this.name().replace("__", "'").replace("_", " ");
    }

}
