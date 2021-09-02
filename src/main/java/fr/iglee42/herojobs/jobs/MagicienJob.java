package fr.iglee42.herojobs.jobs;

import fr.iglee42.herojobs.utils.Job;
import org.bukkit.Material;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

public class MagicienJob extends Job {
    public MagicienJob() {
        super("Magicien", 20);
    }

    @Override
    public void init() {
        super.init();
        initPotion();
    }

    @Override
    public void initPotion() {
        super.initPotion();
        for (int i = 0; i <= 4; i++) {

            Map<PotionEffectType, Integer> maps = new HashMap<>();
            maps.put(PotionEffectType.HEAL, 5);
            maps.put(PotionEffectType.FIRE_RESISTANCE, 3);
            maps.put(PotionEffectType.REGENERATION, 5);
            maps.put(PotionEffectType.INCREASE_DAMAGE, 3);
            maps.put(PotionEffectType.SPEED, 2);
            maps.put(PotionEffectType.NIGHT_VISION, 9);
            maps.put(PotionEffectType.INVISIBILITY, 9);
            maps.put(PotionEffectType.WATER_BREATHING, 2);
            maps.put(PotionEffectType.JUMP, 5);
            maps.put(PotionEffectType.POISON, 4);
            maps.put(PotionEffectType.HARM, 5);
            this.getPotionXp().put(i, maps);
        }
        for (int i = 5; i <= 9; i++) {

            Map<PotionEffectType, Integer> maps = new HashMap<>();
            maps.put(PotionEffectType.HEAL, 4);
            maps.put(PotionEffectType.FIRE_RESISTANCE, 3);
            maps.put(PotionEffectType.REGENERATION, 3);
            maps.put(PotionEffectType.INCREASE_DAMAGE, 2);
            maps.put(PotionEffectType.SPEED, 1);
            maps.put(PotionEffectType.NIGHT_VISION, 3);
            maps.put(PotionEffectType.INVISIBILITY, 4);
            maps.put(PotionEffectType.WATER_BREATHING, 1);
            maps.put(PotionEffectType.JUMP, 5);
            maps.put(PotionEffectType.POISON, 2);
            maps.put(PotionEffectType.HARM, 3);
            this.getPotionXp().put(i, maps);
        }
        for (int i = 10; i <= 14; i++) {

            Map<PotionEffectType, Integer> maps = new HashMap<>();
            maps.put(PotionEffectType.HEAL, 2);
            maps.put(PotionEffectType.FIRE_RESISTANCE, 2);
            maps.put(PotionEffectType.REGENERATION, 2);
            maps.put(PotionEffectType.NIGHT_VISION, 3);
            maps.put(PotionEffectType.INVISIBILITY, 4);
            maps.put(PotionEffectType.JUMP, 4);
            maps.put(PotionEffectType.HARM, 2);
            this.getPotionXp().put(i, maps);
        }
        for (int i = 15; i < 20; i++) {

            Map<PotionEffectType, Integer> maps = new HashMap<>();
            maps.put(PotionEffectType.FIRE_RESISTANCE, 1);
            maps.put(PotionEffectType.REGENERATION, 1);
            maps.put(PotionEffectType.NIGHT_VISION, 1);
            maps.put(PotionEffectType.INVISIBILITY, 3);
            maps.put(PotionEffectType.JUMP, 2);
            maps.put(PotionEffectType.HARM, 1);
            this.getPotionXp().put(i, maps);
        }

    }
}
