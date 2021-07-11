package com.p3achb0t.api.userinputs.naturalmouse.support;

import java.awt.*;
import java.util.Random;

import static com.p3achb0t.api.userinputs.naturalmouse.support.DefaultNoiseProvider.DEFAULT_NOISINESS_DIVIDER;
import static com.p3achb0t.api.userinputs.naturalmouse.support.SinusoidalDeviationProvider.DEFAULT_SLOPE_DIVIDER;

public class DefaultMouseMotionNature extends MouseMotionNature {

  public static final int TIME_TO_STEPS_DIVIDER = 8;
  public static final int MIN_STEPS = 10;
  public static final int EFFECT_FADE_STEPS = 15;
  public static final int REACTION_TIME_BASE_MS = 20;
  public static final int REACTION_TIME_VARIATION_MS = 120;

  public DefaultMouseMotionNature() {
    try {
      setSystemCalls(new DefaultSystemCalls(new Robot()));
    } catch (AWTException e) {
      throw new RuntimeException(e);
    }

    setDeviationProvider(new SinusoidalDeviationProvider(DEFAULT_SLOPE_DIVIDER));
    setNoiseProvider(new DefaultNoiseProvider(DEFAULT_NOISINESS_DIVIDER));
    setSpeedManager(new DefaultSpeedManager());
    setOvershootManager(new DefaultOvershootManager(new Random()));
    setEffectFadeSteps(EFFECT_FADE_STEPS);
    setMinSteps(MIN_STEPS);
    setMouseInfo(new DefaultMouseInfoAccessor());
    setReactionTimeBaseMs(REACTION_TIME_BASE_MS);
    setReactionTimeVariationMs(REACTION_TIME_VARIATION_MS);
    setTimeToStepsDivider(TIME_TO_STEPS_DIVIDER);
  }
}
