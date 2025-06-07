package tcreborn.api.thaumcraft.aspects;

import tcreborn.api.util.exceptions.ParameterArraysSizeException;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class Aspects extends AspectList {

    public Aspects(Aspect aspect, int amount) {
        super.add(aspect, amount);
    }

    public Aspects(Aspect[] aspects, int ... amounts) {
        if (aspects.length != amounts.length) throw new ParameterArraysSizeException(aspects.length, amounts.length);
        for (int i = 0; i < aspects.length; i++)
            super.add(aspects[i], amounts[i]);
    }
}
