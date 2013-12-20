package com.mojang.api.profiles;

public abstract interface ProfileRepository
{
  public abstract Profile[] findProfilesByCriteria(ProfileCriteria... paramVarArgs);
}
